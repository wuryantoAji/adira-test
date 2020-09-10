package com.example.demo.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="contract")
public class ContractModel {
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ContractModel(){}

		public ContractModel(long id, long contract_no, String name, int total_tenor, int rate_kredit, int pokok_hutang) {
			this.id = id;
			this.contract_no = contract_no;
	        this.name = name;
	        this.total_tenor = total_tenor;
	        this.rate_kredit = rate_kredit;
	        this.pokok_hutang = pokok_hutang;
	    }

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
		
		@NotNull
	    @Column(name="contract_no",nullable = false)
	    private long contract_no;

	    @NotNull
	    @Column(name="name",nullable = false)
	    private String name;

	    @NotNull
	    @Column(name="total_tenor",nullable = false)
	    private int total_tenor;
	    
	    @Column(name="tanggal_kredit_input", nullable = true)
	    private Date tanggal_kredit_input;
	    
	    @Column(name="tanggal_kredit", nullable = true)
	    private Date tanggal_kredit;
	    
	   
		@NotNull
	    @Column(name="rate_kredit",nullable = false)
	    private int rate_kredit;
	    
	    @NotNull
	    @Column(name="pokok_hutang",nullable = false)
	    private int pokok_hutang;
	    
	    @NotNull
	    @Column(name="angsuran",nullable = false)
	    private int angsuran;

	    @NotNull
	    @Column(name="bunga",nullable = false)
	    private int bunga;
	    
	    @NotNull
	    @Column(name="tenor_ke",nullable = false)
	    private int tenor_ke;
	    
	    @Column(name="bayar_angsuran",nullable = true)
	    private Integer bayar_angsuran;
	    
	    @Column(name="bayar_bunga",nullable = true)
	    private Integer bayar_bunga;

		public Integer getBayar_angsuran() {
			return bayar_angsuran;
		}

		public void setBayar_angsuran(int bayar_angsuran) {
			this.bayar_angsuran = bayar_angsuran;
		}

		public Integer getBayar_bunga() {
			return bayar_bunga;
		}

		public void setBayar_bunga(int bayar_bunga) {
			this.bayar_bunga = bayar_bunga;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getTotal_tenor() {
			return total_tenor;
		}

		public void setTotal_tenor(int total_tenor) {
			this.total_tenor = total_tenor;
		}

		public Date getTanggal_kredit() {
			return tanggal_kredit;
		}

		public void setTanggal_kredit(Date tanggal_kredit) {
			this.tanggal_kredit = tanggal_kredit;
		}

		 public Date getTanggal_kredit_input() {
				return tanggal_kredit_input;
			}

			public void setTanggal_kredit_input(Date tanggal_kredit_input) {
				this.tanggal_kredit_input = tanggal_kredit_input;
			}

		public int getRate_kredit() {
			return rate_kredit;
		}

		public void setRate_kredit(int rate_kredit) {
			this.rate_kredit = rate_kredit;
		}

		public int getPokok_hutang() {
			return pokok_hutang;
		}

		public void setPokok_hutang(int pokok_hutang) {
			this.pokok_hutang = pokok_hutang;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public long getContract_no() {
			return contract_no;
		}

		public void setContract_no(long contract_no) {
			this.contract_no = contract_no;
		}

		public int getAngsuran() {
			return angsuran;
		}

		public void setAngsuran(int angsuran) {
			this.angsuran = angsuran;
		}

		public int getBunga() {
			return bunga;
		}

		public void setBunga(int bunga) {
			this.bunga = bunga;
		}

		public int getTenor_ke() {
			return tenor_ke;
		}

		public void setTenor_ke(int tenor_ke) {
			this.tenor_ke = tenor_ke;
		}
	    
		
	    
	    
}
