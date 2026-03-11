package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.model.Client;
import isep.eapli.demo_orm.domain.repo.ClientRepository;

public class ClientRepositoryJPAImpl
    extends  BaseRepositoryJPAImpl<Client, Long>
    implements ClientRepository {

}
