Troop {
	*start {
		arg verbose = false;

		'Listening for messages from Troop.'.postln;

		// Listen for other messages and check the password

		OSCFunc(
			{
				arg msg, time, addr, port;
				var interp;

				// If the verbose flag is True, print the code

				if (verbose == true){
					msg[1].asString.postln;
				};

				// Only interpret code sent from a local ip address

				if (NetAddr.matchLangIP(addr.ip) == true) {
					defer {
						thisProcess.interpreter
						.cmdLine_(msg[1].asString)
						.interpretPrintCmdLine;
					}
				} {
					'Warning: external Troop message attempted from'.postln;
					addr.postln;
				};

			},
			'troop'
		);
	}
}
