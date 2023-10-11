package com.gaoming.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet("/upload/*")
public class UploadServlet extends BaseServlet{

    private static final long serialVersionUID = 1L;
    //定义文件上传的目录linux系统路径
    private static final String UPLOAD_DIR = "/www/server/tomcat7/webapps/brand-case/imgs/imageup";//本地路径服务器创建后还需要改成服务器路径
//    private static final String UPLOAD_DIR = "E:\\keyboardworkweb\\-\\src\\main\\webapp\\imgs\\imageup";//本地路径服务器创建后还需要改成服务器路径
    private  static final  String UPLOAD_DIR2 = "E:\\keyboardworkweb\\-\\src\\main\\webapp\\imgs";//本地路径服务器创建后还需要改成服务器路径
    /**
     * 上传图片
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void Image(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        //获取上传后的文件路径
//        String filePath = UPLOAD_DIR + File.separator + fileName;
//        //设置响应内容类型为文本
//        response.setContentType("text/plain");
//        //输出文件路径到响应中
//        response.getWriter().write(filePath);
        try {
            //创建一个 MultipartRequest 对象，指定请求、目录、文件大小限制和编码方式
            MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_DIR, 10 * 1024 * 1024, "UTF-8");

            //获取上传的文件对象
            File file = multipartRequest.getFile("image");

            String realfilename = multipartRequest.getOriginalFileName("image");
            System.out.println(realfilename);

            String imgSuffix = realfilename.substring(realfilename.lastIndexOf("."));

            String newFilename = UUID.randomUUID() +imgSuffix;

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-");
            String datePath = dateFormat.format(new Date());
            File oldName = new File(UPLOAD_DIR+File.separator+realfilename);
            File newName = new File( UPLOAD_DIR+File.separator+datePath+newFilename);
            oldName.renameTo(newName);
            //上传到哪个路径下
            String targetPath = "http://123.249.21.61:8081//brand-case/imgs/imageup" +"/"+ datePath + newFilename;
            System.out.println(oldName);
            System.out.println(newName);
            System.out.println(targetPath);
//            return String.valueOf(targetFilename);//返回文件路径
            response.getWriter().write(targetPath);//资源映射路径
        } catch (IOException e) {
            e.printStackTrace();
            return ;
        }
    }
}
