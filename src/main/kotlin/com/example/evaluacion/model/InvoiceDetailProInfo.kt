package com.example.evaluacion.model

import javax.persistence.*


@Entity
@Table(name = "invoice_customer_info") // Nombre de la vista
class InvoiceCustomerInfoModel {
    // Mapeo de los campos de la vista
    @Id
    @Column(name = "idn")
    var idn: Long? = null

    @Column(name = "cod_invoice")
    var codInvoice: String? = null

    @Column(name = "cre_at_invoice")
    var createdAtInvoice: java.sql.Timestamp? = null

    @Column(name = "tot_invoice")
    var totalInvoice: Double? = null

    @Column(name = "idc_client")
    var idcClient: Int? = null

    @Column(name = "customer_name")
    var customerName: String? = null
}