Troop
{
	classvar verbose;

	*start
	{
		arg verbose = false;

		'Listening for messages from Troop.'.postln;

		// Listen for other messages and check the password

		OSCFunc(
			{
				arg msg, time, addr, port;

				// Only interpret code sent from a local ip address

				if (NetAddr.matchLangIP(addr.ip) == true){
					msg[1].asString.interpret;
				}{
					'Warning: external Troop message attempted from'.postln;
					addr.postln;
				};

				// If the verbose flag is True, print the code

				if (verbose==true){
					msg[1].asString.postln;
				}{};
			},
			'troop'
		);
	}
}
