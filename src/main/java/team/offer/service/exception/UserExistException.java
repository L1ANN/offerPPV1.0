package team.offer.service.exception;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 11:32 2018/1/19
 * @Modified By:
 */
public class UserExistException extends Exception {
    public UserExistException(String message){
        super(message);
    }

    public UserExistException(String message,Throwable cause){
        super(message,cause);
    }
}
