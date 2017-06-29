/*
 * Copyright 2017 HelpPet.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author anne
 */
public class Banco {
    
    private static final Banco instanciaDeBanco = new Banco();
    private static EntityManager manager;

    private Banco() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("helppetweb");
        manager = factory.createEntityManager();
    }

    /**
     *
     * @return Instância de Banco de Dados.
     */
    public static Banco getInstance() {
        return instanciaDeBanco;
    }

    /**
     *
     * @return Genrênciador de entidades JPAs
     */
    public EntityManager getEntityManager() {
        return manager;
    }

}
