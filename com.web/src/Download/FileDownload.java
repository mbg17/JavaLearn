package Download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/download")
public class FileDownload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        ServletContext servletContext = this.getServletContext();
        String mimeType = servletContext.getMimeType(filename);
        String realPath = servletContext.getRealPath("/WEB-INF/file/" + filename);
        response.setHeader("content-type",mimeType);
        response.setHeader("Content-Disposition","attachment;filename="+filename);
        ServletOutputStream outputStream = response.getOutputStream();
        InputStream inputputStream = new FileInputStream(realPath);
        int i=0;
        byte[] bytes= new byte[1024];
        while ((i=inputputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,i);
        }
        inputputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
