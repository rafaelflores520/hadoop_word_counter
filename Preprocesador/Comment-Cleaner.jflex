//10,11,25,60,2
//Mandenos un fichero correcto please ;_;
import java.io.FileWriter;
import java.io.IOException;

%%
%unicode
%class afiliado
%int
%line
%column
%caseless

%{
	private FileWriter writer;

	private void writer(String buff){
		try {
            writer.write(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
%}

%init{
	try{
		writer = new FileWriter("chunk-clean.txt", true);
	}catch(IOException e){
		e.printStackTrace();
	}
%init}

%eof{
	try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
%eof}

remove = a | about | above | after | again | against | all | am | an | and | any | are | "aren't" | as | at | be | because | been | before | being | below | between | both | but | by | can | "can't" | cannot | could | "couldn't" | did | "didn't" | do | does | "doesn't" | doing | "don't" | down | during | each | few | for | from | further | had | "hadn't" | has | "hasn't" | have | "haven't" | having | he | "he'd" | "he'll" | "he's" | her | here | "here's" | hers | herself | him | himself | his | how | "how's" | i | "i'd" | "i'll" | "i'm" | "i've" | if | in | into | is | "isn't" | it | "it's" | its | itself | "let's" | me | more | most | "mustn't" | my | myself | no | nor | not | of | off | on | once | only | or | other | ought | our | ours | ourselves | out | over | own | same | "shan't" | she | "she'd" | "she'll" | "she's" | should | "shouldn't" | so | some | such | than | that | "that's" | the | their | theirs | them | themselves | then | there | "there's" | these | they | "they'd" | "they'll" | "they're" | "they've" | this | those | through | to | too | under | until | up | very | was | "wasn't" | we | "we'd" | "we'll" | "we're" | "we've" | were | "weren't" | what | "what's" | when | "when's" | where | "where's" | which | while | who | "who's" | whom | why | "why's" | with | "won't" | would | "wouldn't" | you | "you'd" | "you'll" | "you're" | "you've" | your | yours | yourself | yourselves | quot | arent | cant | couldnt | didnt | doesnt | dont | hadnt | hasnt | havent | hed | hes | heres | hows | im | ive | isnt | its | shes | shouldnt | thats | theres | theyd | theyll | theyre | theyve | wasnt | wed | weve | were | werent | whats | whos | whys | wont | wouldnt | youd | youll | youre | youve | twice | just | like | likely | later | try | even | will | simply | almost | get | ok | must | else | without | put | unless | much | ah | yeah | maybe | need | also | used | may | yet | obviously | obvious | many | us | use | etc | oh | since | yah | come | knows | know | knew | yes | true | something | really | anything | sense | b+ | c+ | d+ | e+ | f+ | g+ | h+ | i+ | j+ | k+ | l+ | m+ | n+ | o+ | p+ | q+ | r+ | s+ | t+ | u+ | v+ | w+ | x+ | y+ | z+ | lol | within | it'll | ha+ | ja+

palabra = [a-zA-Z]+
usuario = [a-zA-Z_-]+
numero = [0-9]+
espacio = [\n\t\r\s]

user = \/u\/{usuario}
subreddit = \/r\/{usuario}
url = (https?|ftp|file):\/\/[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]
format = &gt
botcomm = The Bitcoin tip for {numero}+ bits \(\${numero}+.{numero}+\) has been collected by \*[a-zA-z_-]+\* | \[ChangeTip info\] \({url}\) \| \[ChangeTip video\] \({url}\) \| {subreddit}




%%
<YYINITIAL>{
	{botcomm}		{}
	{url}			{}
	{format}		{}
	{user}			{}
	{subreddit}		{}
	{remove}		{}
	\/				{writer(" ");}
	{palabra} 		{writer(yytext());}
	{espacio} 		{writer(yytext());}
	. 				{}
}