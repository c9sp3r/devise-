package com.isi.devise_crud.model;

import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.index.Indexed;

	public class Devise {

		@Id
		private String id;

		@Indexed(unique=true)
		private String deviseName;

		private double devisePrice;

		public String getId() {
			return id;
		}

		public String getDevise_name() {
			return deviseName;
		}

		public double getDevise_price() {
			return devisePrice;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setDevise_name(String devise_name) {
			this.deviseName = devise_name;
		}

		public void setDevise_price(double devise_price) {
			this.devisePrice = devise_price;
		}

		public Devise(String devise_name, double devise_price) {
			this.deviseName = devise_name;
			this.devisePrice = devise_price;
		}

		public Devise() {
		}
	}