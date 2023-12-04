module F = Format

let rec interp_expr (e: Ast.expr) (g: FStore.t) (s: Store.t) : Value.t = 
  match e with
  | Num n -> NumV n
  | Id x -> 
    if Store.mem x s then
      Store.find x s
    else 
      failwith (F.sprintf "Free identifier: %s" x)
  | Add (e1, e2) ->
    (match (interp_expr e1 g s, interp_expr e2 g s) with 
    | (NumV n1, NumV n2) -> NumV(n1+n2))

  | Sub (e1, e2) ->   
    (match (interp_expr e1 g s, interp_expr e2 g s) with 
    | (NumV n1, NumV n2) -> NumV(n1-n2))

  | LetIn (x, e1, e2) -> 
    interp_expr e2 g (Store.add x (interp_expr e1 g s) s)

  | Call (x, e) ->
    if FStore.mem x g then 
      let e = List.map (fun cur_e -> interp_expr cur_e g s) e in 
      match (FStore.find x g) with 
      | (def_x2, def_e) -> 
        if List.length def_x2 = List.length e then
          let env= List.combine def_x2 e in
          let new_g = (FStore.add x (FStore.find x g) g) in
          let temp_new_s = ref s in List.iter (fun (param, arg) -> temp_new_s := Store.add param arg !temp_new_s) env;
          let new_s = !temp_new_s in
          interp_expr def_e new_g new_s
        else
          failwith (F.sprintf "The number of arguments of x mismatched: Required: %d, Actual: %d" (List.length def_x2) (List.length e))
    else
      failwith (F.sprintf "Undefined function: %s" x) 
  
let interp_fundef (d: Ast.fundef) (g: FStore.t) : FStore.t = 
  match d with 
  | FunDef (x1, x2, e)-> FStore.add x1 (x2, e) g

let interp (p : Ast.prog) : Value.t = 
  match p with 
  | Prog (d , e) -> 
    match (d, e) with 
    | (d_first:: _ , e) ->interp_expr e (interp_fundef d_first FStore.empty) Store.empty
    | ([], e) -> interp_expr e FStore.empty Store.empty 
   