#NOTES

## Tips for TDD : 
### 🧪 Typical TDD Cycle (Red-Green-Refactor) for Logic
Write a failing test (Red) for a specific logic (e.g., ViewModel should emit UI state X when event Y happens).
Implement just enough logic (Green) to make the test pass.
Refactor to clean up without breaking the test.
This cycle is fast and provides clear design feedback when applied to logic layers.

## Git + TDD
git checkout -b feature/counter

# RED
[Write failing test]
git add .
git commit -m "test(counter): add failing test for increment"

# GREEN
[Implement logic to pass test]
git add .
git commit -m "feat(counter): implement increment logic"

# REFACTOR
[Clean code]
git add .
git commit -m "refactor(counter): simplify state management"

## what is BDD ?
https://katalon.com/resources-center/blog/bdd-testing
