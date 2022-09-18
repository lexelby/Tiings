package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_78
   extends TilingType
{
   public TilingTypeNC6_78(){
      super( "NC6-78", 6, SymmetryType.p6 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 40, 20, 30};
      paramName = new String[]{"Relative Length", "X", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,5, 0,0,1, 0},
            {0, 0,5, 1,0,1, 0},
            {0, 0,5, 2,0,1, 0},
            {0, 0,5, 3,0,1, 0},
            {0, 0,5, 4,0,1, 0},
      };
      info = "a+c=b\nd=f\nA=60\nB=120\nD+E=360\n(C+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1.5;
      double ln1 = ln * getParam(paramValues,0)/100;
      double ln2 = ln-ln1;
      double c = .5;
      double s = Math.sqrt(3)/2;
      
      double x = ln * getParam(paramValues,1)/100;
      double y = ln * getParam(paramValues,2)/100;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, ln + ln1*c, ln1*s);
      baseTile.setPoint(3, ln-x+(ln-y)*c, (ln-y)*s );
      baseTile.setPoint(4,  x+y*c,  y*s);
      baseTile.setPoint(5,  ln2*c, ln2*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(5)-tiles[0].getX(2);
      offsets[1] = tiles[3].getY(5)-tiles[0].getY(2);
      offsets[2] = tiles[4].getX(5)-tiles[1].getX(2);
      offsets[3] = tiles[4].getY(5)-tiles[1].getY(2);
   }
}