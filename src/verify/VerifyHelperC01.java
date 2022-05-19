package verify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class VerifyHelperC01 extends IdVerifyHelper {

	@Override
	public List<VerifyResult> validate(String filename) {
		List<VerifyResult> resultList = new ArrayList<>();
		int[] letterNums = { 10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32,
				30, 31, 33 };
		try {
			File file = new File(filename);
			BufferedReader br = new BufferedReader(new FileReader(String.valueOf(file)));
			String s;
			while ((s = br.readLine()) != null) {
				VerifyResult vr = new VerifyResult();
				vr.setId(s);
				System.out.println("====您輸入的身分證字號 " + s + "====");
				if (s.length() == 10) {
					if (s.matches("[A-Z]\\d{9}")) {
						if (s.charAt(1) == '1' || s.charAt(1) == '2') {
							char letter = s.charAt(0);
							s = letterNums[letter - 'A'] + s.substring(1);
							int total = s.charAt(0) - '0';
							for (int i = 1; i < 10; i++) {
								total += (s.charAt(i) - '0') * (10 - i);
							}
							int checkNum = (10 - total % 10) % 10;
							if (checkNum == (s.charAt(10) - '0')) {
								System.out.println("====驗證成功====");
								vr.setVerifySuccess(true);
								vr.setMessage("驗證成功");
								resultList.add(vr);
							} else {
								System.out.println("====驗證失敗====");
								vr.setVerifySuccess(false);
								vr.setMessage("驗證失敗");
								resultList.add(vr);
							}
						} else {
							System.out.println("====驗證失敗====");
							vr.setVerifySuccess(false);
							vr.setMessage("驗證失敗");
							resultList.add(vr);
						}
					} else {
						System.out.println("====驗證失敗====");
						vr.setVerifySuccess(false);
						vr.setMessage("證號格式錯誤");
						resultList.add(vr);
					}
				} else {
					System.out.println("====驗證失敗====");
					vr.setVerifySuccess(false);
					vr.setMessage("證號長度不為10");
					resultList.add(vr);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
