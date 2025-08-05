# TIC TAC TOE - TDD
link: https://kata-log.rocks/tic-tac-toe-kata

## RULES WITH BDD

- Given the user is on the game view
  When all fields in a row are taken
  Then the game is over

- Given the user is on the game view
  When all fields in a column are taken
  Then the game is over

- Given the user is on the game view
  When all fields in a diagonal are taken
  Then the game is over

- Given the user is on the game view
  When all fields are taken
  Then the game is over

- Given the user on the game view
  When takes turn
  Then taking the fields until the game is over

- Given the user is in the game view
  When a field is not already taken
  Then the play can take the field

- Given in the game view
  When playing
  Then there two players : X and Y

- Given in the game view
  When playing
  Then the game has nine fields in 3x3 grid

### NAMING TEST FUNCTION
-> should set symbol X on position when first player plays

### TIPS
- test view model
- test for every conditions: if, when, ...
- test UI jetpack compose
- think about theme : dark and light
- use MVI with sealed class with mutable state flow

### Edge cases
 - What happens if a player tries to play in a non-empty cell?
 - What if the game is over and someone tries to play?



