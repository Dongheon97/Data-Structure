public enum OrderValidity {
	EndOfRun,
	Valid,
	TooSmall,
	TooLarge,
	NotOddNumber ;
	
	public static OrderValidity validitiyOf(int order) {
		if(order < 0) {
			return OrderValidity.EndOfRun;
		}
		else if(order < AppController.MIN_ORDER) {
			return OrderValidity.TooSmall;
		}
		else if(order > AppController.MAX_ORDER) {
			return OrderValidity.TooLarge;
		}
		else if( (order%2)==0) {
			return OrderValidity.NotOddNumber;
		}
		else {
			return OrderValidity.Valid;
		}
	}
}
