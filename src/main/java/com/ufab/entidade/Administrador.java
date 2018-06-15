package com.ufab.entidade;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Representa os adminstradores do sistema
 * @author Davi
 *
 */
@Entity(name = "administrador")
@Table(name = "administrador")
public class Administrador extends Usuario {

	private static final long serialVersionUID = -8849533159458427899L;
	
	
}
