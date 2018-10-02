package pers.opappo.playlist.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pers.opappo.playlist.VO.ResultVO;
import pers.opappo.playlist.enums.ResultEnum;
import pers.opappo.playlist.utils.ResultVOUtil;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by minghli on 2018/9/29.
 */
@RestController
@RequestMapping("/file")
public class UploadController {
    @PostMapping("/upone")
    public ResultVO uploadOne(@RequestParam("customFile") MultipartFile file) throws IOException {


        String filePath = file.getOriginalFilename(); // 获取文件的名称
        filePath = "C:/Users/minghli/Desktop/up/" + filePath;

        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));

        outputStream.write(file.getBytes());
        outputStream.flush();
        outputStream.close();


        if (file != null) {
            return ResultVOUtil.success("上传");
        }

        return ResultVOUtil.error(ResultEnum.UPLOAD_FAILED);
    }

    @PostMapping("/uplist")
    public ResultVO uploadList(@RequestParam("customFile") MultipartFile[] files) throws IOException {


        //tmp文件
        //String fileName = file.getOriginalFilename();
        //String prefix = fileName.substring(fileName.lastIndexOf("."));
        //final File excelFile = File.createTempFile(java.util.UUID.randomUUID().toString(), prefix);
        //file.transferTo(excelFile);
        //


        // 多文件上传
        for (int i = 0; i < files.length; i++) {
            String filePath = files[i].getOriginalFilename(); // 获取文件的名称
            filePath = "C:/Users/minghli/Desktop/up/" + filePath;

            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));

            outputStream.write(files[i].getBytes());
            outputStream.flush();
            outputStream.close();
        }


        if (files.length != 0) {

            return ResultVOUtil.success("上传");
        }

        return ResultVOUtil.error(ResultEnum.UPLOAD_FAILED);
    }
}
