package factory;

import com.example.AbstractFactory;

import address.Address;
import address.USAAddress;
import exeptions.TelephoneFormatException;
import telephone.Telephone;
import telephone.USATelephone;

public class USAFactory implements AbstractFactory{

	@Override
	public Address createAddress() {
		return new USAAddress();
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new USATelephone(telephone);
	}
	
}
