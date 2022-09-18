package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_62a
   extends TilingType
{
   public TilingTypeNC5_62a(){
      super( "NC5-62a", 5, SymmetryType.p2 );

      paramMin = new int[]{-100};
      paramMax = new int[]{ 100};
      paramDef = new int[]{   0};
      paramName = new String[]{ "Offset"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,3, 0,0,3, 0},
            {0, 2,3, 1,0,4, 0},
            {1, 1,3, 2,0,3, 0},
      };
      info = "c=d=e=a\nA=36\nB=72\nC=144\nD=72\n(E=216)";
   }

   public void recalcBase(double[] paramValues) {
      double c36 = (Math.sqrt(5)+1)/4;
      double s36 = Math.sqrt(1-c36*c36);
      double s72 = 2*c36*s36;
      double c72 = c36*c36-s36*s36;

      double ln = .5;
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln*(2*c36 + 2*c72),  0);
      baseTile.setPoint(2, ln*(2*c36 + c72), ln*s72);
      baseTile.setPoint(3, ln*(c36 + c72), ln*(s36 + s72));
      baseTile.setPoint(4, ln*c36, ln*s36);
   }
   public void recalcOffsets(double[] paramValues) {
      double d1x = tiles[0].getX(1)-tiles[0].getX(0);
      double d1y = tiles[0].getY(1)-tiles[0].getY(0);
      double d2x = tiles[2].getX(1)-tiles[0].getX(0);
      double d2y = tiles[2].getY(1)-tiles[0].getY(0);
      double os = paramValues[0]/100.;
      if( os<0 ){
         offsets[0] = d1x;
         offsets[1] = d1y;
         offsets[2] = d2x+os*d1x;
         offsets[3] = d2y+os*d1y;
      }else{
         offsets[0] = d1x+os*d2x;
         offsets[1] = d1y+os*d2y;
         offsets[2] = d2x;
         offsets[3] = d2y;
      }
   }
}
