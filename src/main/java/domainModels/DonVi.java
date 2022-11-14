/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModels;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author QUOC HUY
 */
@Table(name = "DonVi")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonVi implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;  
    
    @Column(name = "DonViGoc")
    private String donViGoc;
    
    @Column(name = "DonViQuyDoi")
    private String donViQuyDoi;
    
    @Column(name = "SoLuong")
    private int soLuong;
}
