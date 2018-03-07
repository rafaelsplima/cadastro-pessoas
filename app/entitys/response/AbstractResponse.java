package entitys.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class AbstractResponse {
	
	private String icon;
	
	private String tipo;
	
	private String msg;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public AbstractResponse(String icon, String tipo, String msg) {
		
		this.icon = icon;
		this.tipo = tipo;
		this.msg = msg;
	}
	
	public enum IconEnum {
		THUMBS_UP("thumbs-up"),
		WARNING_SIGN("warning-sign"),
		REMOVE("remove");
		
		private String desc;
		
		private IconEnum(String desc) {
			this.desc = desc;
		}

		public String getDesc() {
			return desc;
		}
	}
	
	public enum TypeEnum {
		DANGER("danger"),
		WARNING("warning"),
		SUCCESS("success");
		
		private String desc;
		
		private TypeEnum(String desc) {
			this.desc = desc;
		}

		public String getDescricao() {
			return desc;
		}
	}
	
}
