/**
 * 
 */
package org.cuatrovientos.customer;

/**
 * Simple class to use a database
 * @author Irene
 *
 */
public class Customer {
	private int id;	
	private String name;
	
	/**
	 * @param name2 
	 * @param id2 
	 * 
	 */
		
	public Customer(int idCard, String Name){
		this.id = idCard;
		this.name = Name;
	}

		/**
		 * @return the id
		 */
		public int getIdCard() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setIdCard(int idCard) {
			this.id = idCard;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Customer [id=" + id + ", name=" + name + "]";
		}
	
		

}
