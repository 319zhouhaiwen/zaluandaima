package crsjk;

import java.util.Date;

public class Auth {
	private Integer id;// id
	private String name;// ����
	private String code;// ����
	private String url;// url
	private String pCode;// �����˵���code
	private String isButton;// 0�ǹ��ܰ�ť��1�ǲ˵�
	private String isDel;// �Ƿ�ɾ�� 0δɾ����1ɾ��
	private String creator;//������
	private String create_time;//����ʱ��
	private String modifier;//�޸���
	private String   modify_time;//�޸�ʱ��

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
