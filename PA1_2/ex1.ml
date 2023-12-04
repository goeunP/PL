let rec gcd n m =
	if n>=m then 
		if m=0 then n
		else gcd (n-m) m
	else 
		if n=0 then m
		else gcd (m-n) n ;;

let _=
	Format.printf "%d\n" (gcd 10 0);
	Format.printf "%d\n" (gcd 9 5) ;
	Format.printf "%d\n" (gcd 13 13);
	Format.printf "%d\n" (gcd 37 600);
	Format.printf "%d\n" (gcd 0 0)

