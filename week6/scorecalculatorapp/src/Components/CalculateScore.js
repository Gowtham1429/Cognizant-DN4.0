import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore() {
  const name = 'John Doe';
  const school = 'ABC School';
  const total = 450;
  const goal = 500;
  const average = total / 5;

  return (
    <div className="score-box">
      <h2>{name}</h2>
      <p>School: {school}</p>
      <p>Score: {total} / {goal}</p>
      <p>Average: {average}</p>
    </div>
  );
}

export default CalculateScore;