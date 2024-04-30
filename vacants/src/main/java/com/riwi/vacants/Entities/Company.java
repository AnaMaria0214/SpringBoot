package com.riwi.vacants.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name ="company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company { 
@Id
@GeneratedValue(strategy = GenerationType.UUID)
private String id;
@Column(length = 40, nullable = false)
private String name;
@Column(length = 60, nullable = false)
private String location;
@Column(length = 15, nullable = false)
private String  contact;

/** una compa;ia puede tener muchas vacantes por eso la relacion es uno a muchos **/
@OneToMany ( mappedBy = "company" ,fetch = FetchType.EAGER, cascade = CascadeType.ALL,
orphanRemoval = false ) 
/* en mappedBy debemos especificar en donde o en que propiedad se esta mapeando(guardando) en la otra entidad */
/* En cascadeType especificamos el tipo de cascada , el All incluye todos los tipos */
/* en orphanRemoval especificamos que un objeto sera eliminado si se elimina su padre */
@ToString.Exclude /* Con esto excluimos el to string que esta en la lista  */
@EqualsAndHashCode.Exclude /* Con esto excluimos las propiedades dentro de la lista  */
private List<Vacant> vacants;
}
