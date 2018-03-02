package team.offer.service.exception;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 13:06 2018/1/19
 * @Modified By:
 */
public class DeleteRepeatException extends RuntimeException {
    public DeleteRepeatException(String message){
        super(message);
    }

    public DeleteRepeatException(String message,Throwable source){
        super(message,source);
    }
}
