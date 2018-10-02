package pers.opappo.playlist.utils;

import pers.opappo.playlist.VO.ResultVO;
import pers.opappo.playlist.enums.ResultEnum;

/**
 * Created by minghli on 2018/9/28.
 */
public class ResultVOUtil {


    /**
     * 带前缀的成功
     *
     * @param pre
     * @return
     */
    public static ResultVO success(String pre) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(pre + ResultEnum.SUCCESS.getMessage());

        return resultVO;
    }

    /**
     * 带前缀和data的成功
     *
     * @param pre
     * @param object
     * @return
     */
    public static ResultVO success(String pre, Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(pre + ResultEnum.SUCCESS.getMessage());
        resultVO.setData(object);

        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());

        return resultVO;
    }
}
