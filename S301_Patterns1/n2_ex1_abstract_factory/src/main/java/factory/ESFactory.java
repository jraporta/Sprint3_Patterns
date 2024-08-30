package factory;

import com.example.AbstractFactory;

import address.Address;
import address.ESAddress;
import exeptions.TelephoneFormatException;
import telephone.ESTelephone;
import telephone.Telephone;

public class ESFactory implements AbstractFactory{

	@Override
	public Address createAddress() {
		return new ESAddress();
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new ESTelephone(telephone);
	}

}
