/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.slo.tecinfo.devweb.repository;

import br.edu.ifsc.slo.tecinfo.devweb.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ramao
 */
@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
    
}
