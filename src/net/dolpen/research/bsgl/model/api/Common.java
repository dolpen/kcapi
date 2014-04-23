package net.dolpen.research.bsgl.model.api;

/**
 * 基本的に全部のデータにくっつく感じ
 */
public class Common {
    public int api_result;
    public String api_result_msg;

    public boolean isSuccess() {
        return "成功".equals(api_result_msg);
    }
}
