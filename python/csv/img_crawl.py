import os
import time
import requests
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager

# 1. 저장할 폴더 생성
save_dir = 'hospital_images'
if not os.path.exists(save_dir):
    os.makedirs(save_dir)

options = webdriver.ChromeOptions()
# options.add_argument('--headless') # 창 안띄우기
driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=options)

try:
    # 굿닥의 '병원 찾기' 또는 '상세 페이지' 리스트로 접속하는 것이 좋습니다.
    # 여기서는 예시로 메인 페이지에서 병원 관련 이미지가 포함된 영역을 타겟팅합니다.
    url = "https://www.goodoc.co.kr/hospitals" # 병원 리스트 페이지
    driver.get(url)
    time.sleep(5) # 로딩 대기

    # 스크롤을 내려서 이미지가 로드되게 함 (Lazy Loading 대응)
    driver.execute_script("window.scrollTo(0, document.body.scrollHeight/2);")
    time.sleep(2)

    # 병원 리스트 아이템 내의 이미지만 선택 (굿닥의 CSS 구조에 맞춤)
    # 보통 .HospitalItem_image 나 img 태그 중 특정 사이즈 이상인 것을 고름
    hospital_imgs = driver.find_elements(By.CSS_SELECTOR, "img")

    img_count = 0
    for idx, img in enumerate(hospital_imgs):
        try:
            # 이미지 주소 가져오기
            img_url = img.get_attribute('src') or img.get_attribute('data-src')
            
            # 1. 주소가 없거나 로고, 아이콘인 경우 제외 (필터링)
            if not img_url or 'http' not in img_url: continue
            if 'logo' in img_url.lower() or 'icon' in img_url.lower() or 'svg' in img_url: continue
            
            # 2. 이미지 크기 확인 (너무 작은 이미지는 아이콘일 확률이 높음)
            width = img.size['width']
            height = img.size['height']
            if width < 100 or height < 100: continue

            # 이미지 다운로드
            response = requests.get(img_url, timeout=10)
            if response.status_code == 200:
                ext = 'jpg' # 기본 확장자
                file_path = f'{save_dir}/hospital_{img_count}.{ext}'
                
                with open(file_path, 'wb') as f:
                    f.write(response.content)
                
                print(f"✅ 병원 이미지 저장: {file_path} (크기: {width}x{height})")
                img_count += 1

        except Exception as e:
            continue

    print(f"\n✨ 총 {img_count}개의 병원 이미지를 수집했습니다.")

finally:
    driver.quit()