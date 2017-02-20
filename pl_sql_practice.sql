DECLARE
  food_id INTEGER;
  food_name VARCHAR2;
  amount REAL := 0;
CREATE PROCEDURE add_food (
  new_food_id_in IN
    food_table.food_id%TYPE)
IS
  l_food  food_table%ROWTYPE;
BEGIN
  SELECT food_id,
         food_name,
         amount
    INTO l_food
    FROM food_table
  WHERE food_id = new_food_id_in;
END;