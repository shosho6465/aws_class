import requests
import xml.etree.ElementTree as ET
import time

service_key = "9f45f7a1696e595dddf89a923c94381ac985eb9256f89b343fb93bb0477d020b"
url = "https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire"

all_names = []  # 모든 약국 이름을 담을 리스트
all_responses = [] # 모든 응답 XML을 담을 리스트
all_items = []

print("--- [시작] 전국 약국 데이터 수집 (약 23회 호출 예정) ---")

# 1페이지부터 25페이지까지 돌리면 25,000건이라 전국 데이터가 다 들어옵니다.
for i in range(1, 26):
		params = {
				'serviceKey' : service_key,
				'pageNo' : str(i),      # 숫자 i를 문자열로 바꿔서 전달!
				'numOfRows' : '1000'    # 한 번에 1000개씩!
		}

		try:
				response = requests.get(url, params=params, timeout=30)
					
				if response.status_code == 200:
						root = ET.fromstring(response.text)
						names = [e.text for e in root.findall(".//dutyName")]
						if i == 1:
							mainroot = root
						else:  
							all_items.append(root.find(".//items"))
						
						if not names: # 더 이상 가져올 데이터가 없으면 중단
								print(f"[{i}페이지] 더 이상 데이터가 없습니다. 종료합니다.")
								break
								
						all_names.extend(names)
						all_responses.append(response.text)
						print(f"✅ {i}페이지 수신 성공! (현재까지 누적: {len(all_names)}개)")
						
						# 너무 빨리 요청하면 서버가 차단할 수 있으니 0.5초씩 쉽니다.
						time.sleep(0.5) 
				else:
						print(f"❌ {i}페이지 실패: {response.status_code}")
						break

		except Exception as e:
				print(f"❌ {i}페이지 오류 발생: {e}")
				break

# --- 결과 저장 및 출력 ---
print(f"\n총 {len(all_names)}개의 약국을 찾았습니다!")

# 마지막 결과만 파일로 저장하거나, 전체를 합쳐서 저장할 수 있습니다.
# 일단 확인을 위해 마지막 페이지 기준으로 저장할게요.
for items in all_items:
		for item in items.findall("./item"):
			mainroot.find(".//items").append(item)
# with open("약국정보3.xml", "w", encoding="utf-8") as f:
#	f.write("\n".join(all_responses))
with open("./약국목록정보조회.xml", "w", encoding="utf-8") as f:
		f.write(ET.tostring(mainroot, encoding="unicode")) # 모든 응답을 한 파일에 합침

print("✅ '약국목록정보조회.xml'에 모든 데이터 저장 완료!")