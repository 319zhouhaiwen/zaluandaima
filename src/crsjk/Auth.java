package crsjk;

import java.util.Date;

public class Auth {
	private Integer id;// id
	private String name;// 名称
	private String code;// 编码
	private String url;// url
	private String pCode;// 父级菜单的code
	private String isButton;// 0是功能按钮，1是菜单
	private String isDel;// 是否删除 0未删除，1删除
	private String creator;//创建人
	private String create_time;//创建时间
	private String modifier;//修改人
	private String   modify_time;//修改时间

	public Integer getId() {
		return id;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}


	public String getModify_time() {
		return modify_time;
	}

	public void setModify_time(String modify_time) {
		this.modify_time = modify_time;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	

	public String getIsDel() {
		return isDel;
	}

	public String getIsButton() {
		return isButton;
	}

	public void setIsButton(String isButton) {
		this.isButton = isButton;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	@Override
	public String toString() {
		return "Auth [id=" + id + ", name=" + name + ", code=" + code + ", url=" + url + ", pCode=" + pCode
				+ ", isButton=" + isButton + ", isDel=" + isDel + ", creator=" + creator + ", create_time="
				+ create_time + ", modifier=" + modifier + ", modify_time=" + modify_time + "]";
	}
	
}
