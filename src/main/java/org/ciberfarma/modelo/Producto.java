package org.ciberfarma.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="tb_productos")
public class Producto {
	@Id
	private String id_prod; /*char*/
	private String des_prod;
	private int stk_prod;
	private double pre_prod;
	private int idcategoria;
	private int est_prod; /*boleano*/
	private int idprovedor;
	
	//Set y Get
	public String getId_prod() {
		return id_prod;
	}
	public void setId_prod(String id_prod) {
		this.id_prod = id_prod;
	}
	public String getDes_prod() {
		return des_prod;
	}
	public void setDes_prod(String des_prod) {
		this.des_prod = des_prod;
	}
	public int getStk_prod() {
		return stk_prod;
	}
	public void setStk_prod(int stk_prod) {
		this.stk_prod = stk_prod;
	}
	public double getPre_prod() {
		return pre_prod;
	}
	public void setPre_prod(double pre_prod) {
		this.pre_prod = pre_prod;
	}
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public int getEst_prod() {
		return est_prod;
	}
	public void setEst_prod(int est_prod) {
		this.est_prod = est_prod;
	}
	public int getIdprovedor() {
		return idprovedor;
	}
	public void setIdprovedor(int idprovedor) {
		this.idprovedor = idprovedor;
	}

	
}
