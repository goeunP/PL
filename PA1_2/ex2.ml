let fibo n=
	let rec tail_fibo n prev pprev=
		if(n=0) then pprev
		else if (n=1) then prev
		else tail_fibo (n-1) (prev+pprev) prev in
		tail_fibo n 1 0 ;;

let _=
	Format.printf "%d\n" (fibo 0);
	Format.printf "%d\n" (fibo 1);
	Format.printf "%d\n" (fibo 2);
	Format.printf "%d\n" (fibo 3);
  Format.printf "%d\n" (fibo 7);
	Format.printf "%d\n" (fibo 10)

