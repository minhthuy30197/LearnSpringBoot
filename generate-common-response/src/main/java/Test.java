import com.google.gson.Gson;
import common.CommonFunctions;
import common.ErrorEnum;
import dto.StatusResponse;

public class Test {
  public static void main(String[] args) {
    StatusResponse sr = CommonFunctions.generateResponse(ErrorEnum.USER_NOT_FOUND, null);
    Gson gson = new Gson();
    System.out.println(gson.toJson(sr));
  }
}
