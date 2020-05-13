
public enum MainMenu {

	Error,
	
	DoesContain,
	ElementAt,
	First,
	Last,
	OrderOf,
	
	AddTo,
	AddToFirst,
	AddToLast,
	Add,
	
	RemoveFrom,
	RemoveFirst,
	RemoveLast,
	RemoveAny,
	
	ReplaceAt,
	Clear,
	
	EndOfRun;
	
	private static final int END_OF_RUN = 99;
	
	public static MainMenu value(int menuNumber) {
		if (menuNumber == END_OF_RUN) {
			return MainMenu.EndOfRun;
		}
		else if(menuNumber < DoesContain.ordinal() || menuNumber> Clear.ordinal()) {
			return MainMenu.Error;
		}
		else {
			return MainMenu.values()[menuNumber];
		}
	}
}
