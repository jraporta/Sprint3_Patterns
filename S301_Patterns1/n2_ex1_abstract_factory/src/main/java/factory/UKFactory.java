package factory;

import com.example.AbstractFactory;

import address.Address;
import address.UKAddress;
import exeptions.TelephoneFormatException;
import telephone.Telephone;
import telephone.UKTelephone;

public class UKFactory implements AbstractFactory{

	@Override
	public Address createAddress() {
		return new UKAddress();
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new UKTelephone(telephone);
	}

}
