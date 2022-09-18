package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_46
   extends TilingType
{
   public TilingTypeNC6_46(){
      super( "NC6-46", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 65};
      paramName = new String[]{"Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,3, 0,3,4, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 4,5, 2,5,4, 1},
      };
      info = "a=c=e\nd=f\nA=B\nD+E=360\nD=F\n(A+B+C+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double ln1 = lntotal * getParam(paramValues, 1)/100;
      double ln2 = lntotal - ln1;
      

      double a = getParam(paramValues, 0);

      double mina = ln1<ln2 * 2 ? Math.acos( ln1 / ln2 / 2 ) / DEG2RAD : 0;
      if( a<mina) a = mina;

      double c = ln2 * Math.cos(a * DEG2RAD);
      double s = ln2 * Math.sin(a * DEG2RAD);
      
      baseTile.setPoint(0,       0,     0);
      baseTile.setPoint(1,     ln1,     0);
      baseTile.setPoint(2,   ln1-c,     s);
      baseTile.setPoint(3,(ln1+c)/2,3*s/2);
      baseTile.setPoint(4,(ln1-c)/2,  s/2);
      baseTile.setPoint(5,       c,     s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(5);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(5);
      offsets[2] = tiles[1].getX(0)-tiles[3].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[3].getY(0);
   }
}