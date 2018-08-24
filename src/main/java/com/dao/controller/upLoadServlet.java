package com.dao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.dao.impl.GoodsDaoImpl;
import com.entity.Goods;


/**
 * Servlet implementation class upLoadServlet
 */
@WebServlet(name = "upLoadServlet", urlPatterns = "/upLoadServlet")
public class upLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String gdiscount;
	private int gnowprice;
	private int goriprice;
	private String gpicpath;
	private String gbrand;
	private String gtype;
	private String gname;
	private String gtime;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		GoodsDaoImpl gdi=new GoodsDaoImpl();
		// 获取数据字符串格式设置
				request.setCharacterEncoding("utf-8");
				// 服务器端响应编码格式设置
				response.setContentType("text/html;charset=utf-8");
				// 获得打印输出流 用于响应数据到客户端
				PrintWriter out = response.getWriter();
				// 获取HttpSession对象
				HttpSession session = request.getSession();

		  //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = this.getServletContext().getRealPath("/img");
        //上传时生成的临时文件保存目录
        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
        File file = new File(tempPath);
        if(!file.exists()&&!file.isDirectory()){
            System.out.println("目录或文件不存在！");
            file.mkdir();
        }
        //消息提示
        String message = "";
        try {
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
            diskFileItemFactory.setSizeThreshold(1024*100);
            //设置上传时生成的临时文件的保存目录
            diskFileItemFactory.setRepository(file);
            //2、创建一个文件上传解析器
            ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
            //解决上传文件名的中文乱码
            fileUpload.setHeaderEncoding("UTF-8");
            //监听文件上传进度
            fileUpload.setProgressListener(new ProgressListener(){
                public void update(long pBytesRead, long pContentLength, int arg2) {
                    System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
                }
            });
            //3、判断提交上来的数据是否是上传表单的数据
            if(!fileUpload.isMultipartContent(request)){
                //按照传统方式获取数据
                return;
            }
            //设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
            fileUpload.setFileSizeMax(1024*1024);
          //设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
            fileUpload.setSizeMax(1024*1024*10);
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = fileUpload.parseRequest(request);
	
            for (FileItem item : list) {
                //如果fileitem中封装的是普通输入项的数据
                if(item.isFormField()){
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    String value1 = new String(name.getBytes("iso8859-1"),"UTF-8");
                    if (name.equals("gname")) {
						gname = value;
					} else if (name.equals("gbrand")) {
						gbrand = value;
					} else if (name.equals("gtype")) {
						gtype = value;
					} else if (name.equals("gtime")) {
						gtime = value;
					}else if(name.equals("goriprice")) {
						goriprice =Integer.parseInt(value);
					}else if(name.equals("gnowprice")) {
						gnowprice = Integer.parseInt(value);
					}else if(name.equals("gdiscount")) {
						gdiscount = value;
					}
                }else{
                    //如果fileitem中封装的是上传文件，得到上传的文件名称，
                    String fileName = item.getName();
                    System.out.println(fileName);
                    if(fileName==null||fileName.trim().equals("")){
                        continue;
                    }
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    fileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);
                    gpicpath = ("img/" + fileName);
                    //得到上传文件的扩展名
                    String fileExtName = fileName.substring(fileName.lastIndexOf(".")+1);
                    if("zip".equals(fileExtName)||"rar".equals(fileExtName)||"tar".equals(fileExtName)||"jar".equals(fileExtName)){
                        request.setAttribute("message", "上传文件的类型不符合！！！");
                        request.getRequestDispatcher("admin/message.jsp").forward(request, response);
                        return;
                    }
                    //如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
                    System.out.println("上传文件的扩展名为:"+fileExtName);
                    //获取item中的上传文件的输入流
                    InputStream fis = item.getInputStream();
                    //得到文件保存的名称
                    fileName = mkFileName(fileName);
                    //得到文件保存的路径
                    String savePathStr = mkFilePath(savePath, fileName);
                    System.out.println("保存路径为:"+savePathStr);
                    //创建一个文件输出流
                    FileOutputStream fos = new FileOutputStream(savePathStr+File.separator+fileName);
                    //获取读通道
                    FileChannel readChannel = ((FileInputStream)fis).getChannel();
                    //获取读通道
                    FileChannel writeChannel = fos.getChannel();
                    //创建一个缓冲区
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    //判断输入流中的数据是否已经读完的标识
                    int length = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while(true){
                        buffer.clear();
                        int len = readChannel.read(buffer);//读入数据
                        if(len < 0){
                            break;//读取完毕 
                        }
                        buffer.flip();
                        writeChannel.write(buffer);//写入数据
                    }
                    //关闭输入流
                    fis.close();
                    //关闭输出流
                    fos.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    message = "文件上传成功";
                }
            }
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
            request.setAttribute("message", "单个文件超出最大值！！！");
            request.getRequestDispatcher("admin/message.jsp").forward(request, response);
            return;
        }catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
            request.setAttribute("message", "上传文件的总的大小超出限制的最大值！！！");
            request.getRequestDispatcher("admin/message.jsp").forward(request, response);
            return;
        }catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      Goods good=new Goods(gname, gpicpath, gtime, goriprice, gnowprice, gdiscount, gbrand, gtype);
		   boolean flag=gdi.addGoods(good);
		   if(flag) {
				response.getWriter().print("<script>alert('添加成功!');location='goodsList.jsp';</script>");
			}else {
				response.getWriter().print("<script>alert('添加失败!');location='goodsList.jsp';</script>");
			}
		 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    //生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
    public String mkFileName(String fileName){
        return UUID.randomUUID().toString()+"_"+fileName;
    }
    public String mkFilePath(String savePath,String fileName){
        //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
        int hashcode = fileName.hashCode();
        int dir1 = hashcode&0xf;
        int dir2 = (hashcode&0xf0)>>4;
        //构造新的保存目录
        String dir = savePath + "\\" + dir1 + "\\" + dir2;
        //File既可以代表文件也可以代表目录
        File file = new File(dir);
        if(!file.exists()){
            file.mkdirs();
        }
        return dir;
    }


	}



