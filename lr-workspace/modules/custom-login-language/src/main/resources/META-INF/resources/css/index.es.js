import React from 'react';
import ReactDOM from 'react-dom';


class FormContainer extends React.Component{
	
	constructor(props) {
		super(props);
		this.state = {
			    isLoading: false
		};
	    this.handleSubmit = this.handleSubmit.bind(this);
	}
	
	handleSubmit(event) {
		
		 this.setState({
	          isLoading: true
	        });
		  event.preventDefault(); 
		  
		  var requestOptions = {
				  method: 'POST',
				  headers: new Headers({
				             'Content-Type': 'application/json', // <-- Specifying the Content-Type
				    }),
				  body: JSON.stringify({
				         bearerToken: ''
				      })
		  };
		  Liferay.Util.fetch("/o/mid-tier/set-agreed-liferay-terms", requestOptions)
				  .then(response => response.text())
				  .then( (result) => {
					  console.log("User Updated in Liferay...");  
				   
					  var requestOptions = {
						  method: 'POST',
						  headers: new Headers({
						             'Content-Type': 'application/x-www-form-urlencoded',
						    }),
						  body: JSON.stringify({
								"name": "morpheus",
								"job": "leader"
						  })
				  		};
						Liferay.Util.fetch("https://reqres.in/api/users", requestOptions)
						  .then(response => response.text())
						  .then( (result) => {
							  	console.log("User Created in Other System..."+result); 
							  	this.setState({
							          isLoading: false
							    });
							  })
						  .catch(error => console.log('error', error));
				  
				  })
				  .catch(error => console.log('error', error));
		  
	}
	
	
	render() {
		const { isLoading } = this.state;
		
		return (
				<React.Fragment>
					{!isLoading ? (
							
							<form onSubmit={this.handleSubmit}> 
			                	<h1>Setup your account</h1>
			                    <p>Terms & Conditions</p>
			                    <TermAndContion articleId='43017' languageId='en-us' ></TermAndContion>

			                    <hr />
			                    <TermAndContion articleId='43028' languageId='ca-ES' ></TermAndContion>
			                    <br/> 
			                    <input type="submit" value="Submit" />   
			                </form > 
		                    
					  ) : (
		            		<h3>Submitting Form</h3>	  
		              ) 
	                }
                </React.Fragment>
		
		);
	}
}

class TermAndContion extends React.Component {
	
	state = {
		    isLoading: true,
		    content: "",
		    error: null
		  };
	
	constructor(props) {
		super(props);

	}
	
	fetchWebContent(articleId, languageId) {
	    fetch(`/o/headless-delivery/v1.0/structured-contents/`+articleId+`?p_auth=`+ window.Liferay.authToken, {
	    	headers: new Headers({
	    		'Accept-Language': languageId
	        })
	    })
	      .then(response => response.json())
	      .then(data => {
	        this.setState({
	          content: data,
	          isLoading: false
	        });
	        console.log(data.contentFields[0].contentFieldValue.data);
	      }
	      );
	  }

	componentDidMount() {
	    this.fetchWebContent(this.props.articleId, this.props.languageId);
	}
	
	render() {
		const { isLoading, content, error } = this.state;
		return (
				<React.Fragment>
				 {!isLoading ? (
						                <p dangerouslySetInnerHTML={ {__html: content.contentFields[0].contentFieldValue.data} } ></p>
						                
					        ) : (
				          <h3>Loading...</h3>
				        )
				  }
				</React.Fragment>
		);
	}
}

class AppController extends React.Component {
	
	
	
	render() {
		return (
				
			<div className='AppController'>
				<div className='AppController-board'>
					<FormContainer />
                     
                </div>
                  
				<div className='AppController-info'>
					<div>{/* status */}</div>
					<ol>{/* TODO */}</ol>
				</div>
			</div>
		);
	}
}



export default function(elementId) {
	ReactDOM.render(<AppController />, document.getElementById(elementId));
}