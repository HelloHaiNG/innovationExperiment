package cn.ssh.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.ssh.entity.Article;
import cn.ssh.service.ArticleService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ArticleAction extends ActionSupport implements ModelDriven<Article>{
	private Article article = new Article();
	private ArticleService articleService;
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	/*
	 * 上传文件的存储的临时文件：
	 * F:\创新型实验\Demo\.metadata\.me_tcat\webapps\innovationExperiment\fileupload
	 */
	private File uploadImage;
	
	//上传文件的类型：text/plain
	private String uploadImageContentType;
	
	//上传文件的真实名称
	private String uploadImageFileName;
	
	public File getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}

	public String getUploadImageContentType() {
		return uploadImageContentType;
	}

	public void setUploadImageContentType(String uploadImageContentType) {
		this.uploadImageContentType = uploadImageContentType;
	}

	public String getUploadImageFileName() {
		return uploadImageFileName;
	}

	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}

	public Article getModel() {
		return article;
	}
	//上传稿件页面
	public String toArticlePage() {
		return "toArticlePage";
	}
	//上传稿件
	public String uploadArticle() {
        ServletContext sc = ServletActionContext.getServletContext();		
		String path = sc.getRealPath("/fileupload");		
		File file = new File(path, uploadImageFileName);		
		try {			
			FileUtils.copyFile(uploadImage, file);			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		uploadImage.delete();
		return "uploadArticle";
	}
    //添加稿件页面
	public String toAddPage() {
		return "toAddPage";
	}
	//添加稿件
	public String add() {
		articleService.add(article);
		return "add";
	}
	//稿件列表
	public String list() {
		List<Article> list = articleService.list();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	//查看稿件内容
	public String look() {
		int artId = article.getArtId();
		Article art = articleService.findById(artId);
		if(art!=null) {
			ServletActionContext.getRequest().setAttribute("article", art);
		}
		return "look";
	}
	//删除稿件信息
	public String delete() {
		articleService.delete();
		return "delete";
	}
}
