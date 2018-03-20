import eventEmitter from './eventEmitter';

let answers = {greetings: ['hello, goodbye']}

class FluxStore extends EventEmitter {
  /**
   * Returns all the current answers
   */
  getAnswers() {
    return answers;
  }

  /**
   * Adds an answer
   * @param {Any} answer 
   */
  addAnswer(answer) {
    answers.greetings.push(answer);
  }

  /**
   * Marks answers as correct
   * @param {Number} id 
   */
  markAsCorrect(id) {
    answers.greetings[id] = false;
  }

  /**
   * This will run whenever any action is dispatched, but that is ok, because of switch statement
   * @param {Any} action 
   */
  register(action) {
    switch (action.actionType) {
      case 'FORUM_ANSWER_ADDED':
        console.log('Answer Added');
        this.addAnswer(action.data);
        break;
      case 'FORUM_ANSWER_MARKED_CORRECT':
        console.log('answer marked correct');
        this.markAsCorrect(action.data);
      default:
        break;
    }
  }
}