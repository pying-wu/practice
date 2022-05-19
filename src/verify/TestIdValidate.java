package verify;

import java.util.List;

public class TestIdValidate {

	public static void main(String[] args) {
		IdVerifyHelper helper = new IdVerifyHelper();
		List<VerifyResult> resultList = helper.validate("src/verify/idList3.txt");

		for (VerifyResult result : resultList) {
			String id = result.getId();
			boolean verifySucess = result.isVerifySuccess();
			String message = result.getMessage();
			System.out.println(id);
			System.out.println(verifySucess);
			System.out.println(message);
		}

		System.out.println("======  VerifyHelperC01  ======");
		System.out.println("");

		VerifyHelperC01 helper1 = new VerifyHelperC01();
		List<VerifyResult> resultList1 = helper1.validate("src/verify/idList3.txt");

		for (VerifyResult result : resultList1) {
			String id = result.getId();
			boolean verifySucess = result.isVerifySuccess();
			String message = result.getMessage();
			System.out.println(id);
			System.out.println(verifySucess);
			System.out.println(message);
		}

		System.out.println("");
		System.out.println("====== VerifyHelperC02 開始 ======");
		System.out.println("");

		VerifyHelperC02 helper2 = new VerifyHelperC02();
		List<VerifyResult> resultList2 = helper2.validate("src/verify/idList3.txt");

		for (VerifyResult result : resultList2) {
			String id = result.getId();
			boolean verifySucess = result.isVerifySuccess();
			String message = result.getMessage();
			System.out.println(id);
			System.out.println(verifySucess);
			System.out.println(message);
		}
	}

}
