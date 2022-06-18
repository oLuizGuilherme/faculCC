package arvore;

public class NoArv {
	private int info;
	private NoArv esq, dir;
	/**
	 * @param info
	 */
	public NoArv(int info) {
		this.info = info;
	}
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {
		this.info = info;
	}
	public NoArv getEsq() {
		return esq;
	}
	public void setEsq(NoArv esq) {
		this.esq = esq;
	}
	public NoArv getDir() {
		return dir;
	}
	public void setDir(NoArv dir) {
		this.dir = dir;
	}
}
