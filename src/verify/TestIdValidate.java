package verify;

import java.util.List;

public class TestIdValidate {

	public static void main(String[] args) {
		IdVerifyHelper helper = new IdVerifyHelper();
		List<VerifyResult> resultList = helper.validate("src/verify/idList2.txt");

		for (VerifyResult result : resultList) {
			String id = result.getId();
			boolean verifySucess = result.isVerifySuccess();
			String message = result.getMessage();
			System.out.println(id);
			System.out.println(verifySucess);
			System.out.println(message);
		}
	}

}
