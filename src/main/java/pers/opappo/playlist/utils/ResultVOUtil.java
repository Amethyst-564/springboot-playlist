package pers.opappo.playlist.utils;

import pers.opappo.playlist.VO.ResultVO;
import pers.opappo.playlist.enums.ResultEnum;

/**
 * Created by minghli on 2018/9/28.
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(ResultEnum.SUCCESS.getMessage());

        return resultVO;
    }

    public static ResultVO success() {
        return success("");
    }

    public static ResultVO success(String pre) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(pre + ResultEnum.SUCCESS.getMessage());

        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());

        return resultVO;
    }
}