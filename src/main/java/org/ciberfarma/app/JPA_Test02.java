package org.ciberfarma.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.ciberfarma.modelo.Producto;
public class JPA_Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto p = new Producto();
			
		p.setId_prod("P0021");
		p.setDes_prod("Sana Sana");
		p.setStk_prod(10);
		p.setPre_prod(20.00);
		p.setIdcategoria(2);
		p.setEst_prod(1);
		p.setIdprovedor(1);
		
		//Llamamos al Manager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = factory.createEntityManager();
		
		/*//Si el c�digo existe, actualizar� y sino, insertar�
				try {
					em.getTransaction().begin();
					em.merge(p);
					em.getTransaction().commit();
				} catch (Exception e) {
					System.out.println("Error al Registrar " + e.getMessage());
				}*/
		
		/*//Buscar
		Producto p2 = em.find(Producto.class, "P0021");
		if (p2 == null) {
			System.out.println("Producto no existe");
		}else {
			System.out.println("El nombre del Producto es :" + p2.getDes_prod());
		}*/
		
		//Listar
		List<Producto> lstProductos = em.createQuery("Select p from Producto p",Producto.class).getResultList();
		if (lstProductos == null) {
			System.out.println("No existe ninguna lista");
		}else {
			for (Producto p2 : lstProductos) {
				System.out.println("*********************USUARIO*********************");
				System.out.println("El nombre del Producto es   : " + p2.getDes_prod());
				System.out.println("El Stock del Producto es    : " + p2.getStk_prod());
				System.out.println("*************************************************");
			}
		
		}
				
	}

}
