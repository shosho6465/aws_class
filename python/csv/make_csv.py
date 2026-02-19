import xml.etree.ElementTree as ET
import os
import math
import re

xml_file = "약국목록정보조회.xml"
# 모든 종류의 공백/줄바꿈을 잡는 패턴
clean_pattern = re.compile(r'\s+')

print(f"--- [최종 해결책] 쉼표 및 줄바꿈 완전 제거 시작 ---")

if not os.path.exists(xml_file):
    print(f"❌ 에러: '{xml_file}' 파일이 없습니다.")
else:
    try:
        tree = ET.parse(xml_file)
        root = tree.getroot()
        items = root.findall('.//item')
        total_items = len(items)
        
        chunk_size = math.ceil(total_items / 8)
        
        for i in range(8):
            start_idx = i * chunk_size
            end_idx = (i + 1) * chunk_size
            chunk = items[start_idx : end_idx]
            
            if not chunk: break
                
            csv_output = f"pharmacy_list_part{i+1}.csv"
            
            with open(csv_output, "w", encoding="utf-8-sig") as f:
                for item in chunk:
                    row_values = []
                    for child in item:
                        val = child.text if child.text else ""
                        
                        # 1. 줄바꿈, 탭 등을 공백 한 칸으로 변경
                        val = clean_pattern.sub(' ', val)
                        
                        # 2. [매우 중요] 데이터 안의 쉼표(,)를 제거하거나 다른 문자로 대체
                        # 쉼표가 있으면 CSV 형식이 깨지므로 제거합니다.
                        val = val.replace(',', ' ') 
                        
                        # 3. 데이터 안의 큰따옴표(") 제거
                        val = val.replace('"', '')
                        
                        val = val.strip()
                        row_values.append(f'"{val}"')
                    
                    # 5. 이제 데이터 자체에는 쉼표가 없으므로 안전하게 연결
                    combined_data = ",".join(row_values)
                    f.write(f"{combined_data}\n")
            
            print(f"✅ {csv_output} 저장 완료")

        print(f"\n✨ 모든 쉼표와 줄바꿈을 제거했습니다. 이제 엑셀에서 밀리지 않을 거예요.")

    except Exception as e:
        print(f"❌ 오류 발생: {e}")