package com.ufab.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/***
 * Enum do tipo "TipoItem", com seus respectivos valores e metodos.
 * 
 * @author Bianca
 *
 */
public enum TipoItem{
	MIDIA_DIGITAL,JORNAL,ANAIS_DE_CONGRESSO,LIVRO,REVISTA,TCC
}
